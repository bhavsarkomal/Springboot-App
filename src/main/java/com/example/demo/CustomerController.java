package com.example.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.Example;
import com.example.demo.model.Customer;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class CustomerController {

	List<Customer> data;

	@RequestMapping("/test")
	@ResponseBody
	public String testController() {
		return "Customers";
	}

	// Combined both online api data and local file data
	public void totalCustomerData() throws StreamReadException, DatabindException, IOException {
		String url = "https://services.odata.org/V2/Northwind/Northwind.svc/Customers?$format=json";
		ObjectMapper mapper = new ObjectMapper();

		Customer[] obj = mapper.readValue(new File(
				"C:\\Users\\kb59131\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\JavaAssignment\\Springboot-App\\src\\main\\resources\\static\\local-data.json"),
				Customer[].class);

		Example response = mapper.readValue(new URL(url), Example.class);
		response.getD().getResults().addAll(Arrays.asList(obj));
		data = response.getD().getResults();

	}

	// Get list of customers in JSON format
	@GetMapping(value = "/customers/json")
	public ResponseEntity<List<Customer>> getCustomers() throws StreamReadException, DatabindException, IOException {

		totalCustomerData();
		ResponseEntity<List<Customer>> finalResponse = ResponseEntity.ok(data);
		return finalResponse;
	}

	// Download list of customers in Excel format
	@GetMapping(value = "/customers/excel")
	public void exportToExcel(HttpServletResponse res) throws StreamReadException, DatabindException, IOException {
		totalCustomerData();
		res.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Customer_info.xlsx";
		res.setHeader(headerKey, headerValue);
		ExcelExportClass exp = new ExcelExportClass(this.data);
		exp.export(res);
	}

	// Create multiple customers from JSON
	@PostMapping(value = "/customers/json")
	@ResponseBody
	public String createCustomers(@RequestBody List<Customer> customers)
			throws StreamReadException, DatabindException, IOException, ParseException {
		totalCustomerData();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type dtoListType = new TypeToken<List<Customer>>() {
		}.getType();
		FileReader fr = new FileReader(
				"C:\\Users\\kb59131\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\JavaAssignment\\Springboot-App\\src\\main\\resources\\static\\local-data.json");
		List<Customer> dtos = gson.fromJson(fr, dtoListType);
		fr.close();
		if (null == dtos) {
			dtos = new ArrayList<Customer>();
		}
		for (Customer customer : customers) {
			boolean isPresent = false;
			for (Customer r : data) {
				if (r.getCustomerID().equals(customer.getCustomerID()) ) {
					isPresent = true;
					break;
				}
			}
			if (!isPresent) {
				dtos.add(customer);
				FileWriter fw = new FileWriter(
						"C:\\Users\\kb59131\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\JavaAssignment\\Springboot-App\\src\\main\\resources\\static\\local-data.json");
				gson.toJson(dtos, fw);
				fw.close();

			} else {
				return "customer CustomerID already created";
			}
		}
		return "";
	}
}

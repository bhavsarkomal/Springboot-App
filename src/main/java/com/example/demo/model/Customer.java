
package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "__metadata",
    "CustomerID",
    "CompanyName",
    "ContactName",
    "ContactTitle",
    "Address",
    "City",
    "Region",
    "PostalCode",
    "Country",
    "Phone",
    "Fax",
    "Orders",
    "CustomerDemographics"
})
@Generated("jsonschema2pojo")
public class Customer {

	@JsonProperty(access = Access.WRITE_ONLY)
    private Metadata metadata;
    @JsonProperty("CustomerID")
    private String CustomerID;
    @JsonProperty("CompanyName")
    private String CompanyName;
    @JsonProperty("ContactName")
    private String ContactName;
    @JsonProperty("ContactTitle")
    private String ContactTitle;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("City")
    private String City;
    @JsonProperty("Region")
    private Object Region;
    @JsonProperty("PostalCode")
    private String PostalCode;
    @JsonProperty("Country")
    private String Country;
    @JsonProperty("Phone")
    private String Phone;
    @JsonProperty("Fax")
    private String Fax;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Orders Orders;
    @JsonProperty(access = Access.WRITE_ONLY)
    private CustomerDemographics CustomerDemographics;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("__metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("__metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("CustomerID")
    public String getCustomerID() {
        return CustomerID;
    }

    @JsonProperty("CustomerID")
    public void setCustomerID(String customerID) {
        this.CustomerID = customerID;
    }

    @JsonProperty("CompanyName")
    public String getCompanyName() {
        return CompanyName;
    }

    @JsonProperty("CompanyName")
    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    @JsonProperty("ContactName")
    public String getContactName() {
        return ContactName;
    }

    @JsonProperty("ContactName")
    public void setContactName(String contactName) {
        this.ContactName = contactName;
    }

    @JsonProperty("ContactTitle")
    public String getContactTitle() {
        return ContactTitle;
    }

    @JsonProperty("ContactTitle")
    public void setContactTitle(String contactTitle) {
        this.ContactTitle = contactTitle;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return Address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.Address = address;
    }

    @JsonProperty("City")
    public String getCity() {
        return City;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.City = city;
    }

    @JsonProperty("Region")
    public Object getRegion() {
        return Region;
    }

    @JsonProperty("Region")
    public void setRegion(Object region) {
        this.Region = region;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return PostalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.PostalCode = postalCode;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return Country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.Country = country;
    }

    @JsonProperty("Phone")
    public String getPhone() {
        return Phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.Phone = phone;
    }

    @JsonProperty("Fax")
    public String getFax() {
        return Fax;
    }

    @JsonProperty("Fax")
    public void setFax(String fax) {
        this.Fax = fax;
    }

    @JsonProperty("Orders")
    public Orders getOrders() {
        return Orders;
    }

    @JsonProperty("Orders")
    public void setOrders(Orders orders) {
        this.Orders = orders;
    }

    @JsonProperty("CustomerDemographics")
    public CustomerDemographics getCustomerDemographics() {
        return CustomerDemographics;
    }

    @JsonProperty("CustomerDemographics")
    public void setCustomerDemographics(CustomerDemographics customerDemographics) {
        this.CustomerDemographics = customerDemographics;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//	@Override
//	public String toString() {
//		return "Result [metadata=" + metadata + ", customerID=" + customerID + ", companyName=" + companyName
//				+ ", contactName=" + contactName + ", contactTitle=" + contactTitle + ", address=" + address + ", city="
//				+ city + ", region=" + region + ", postalCode=" + postalCode + ", country=" + country + ", phone="
//				+ phone + ", fax=" + fax + ", orders=" + orders + ", customerDemographics=" + customerDemographics
//				+ ", additionalProperties=" + additionalProperties + "]";
//	}

}

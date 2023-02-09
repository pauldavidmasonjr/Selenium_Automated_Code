package Objects.WebApp;

import java.util.List;

public class Plan {



   private Integer companyId = 0;
   private String name = "";
   private String displayName = "";
   private String planType = "";
   private List<String> serviceAreas;
   private List<String> coveredPropertyTypes;
   private String serviceFrequency;
   private String billingFrequency;
   private String billingFrequencyNotes;
   private String startDate;
   private String endDate;
   private String measurementUnit;
   private List<PricingTier> priceTiers;
   private List<Service> services;

   public Plan(String comName, Integer comId, String name, String displayName, String planType, List<String> serviceAreas, List<String> coveredPropertyTypes, String serviceFrequency, String billingFrequency, String billingFrequencyNotes, String startDate, String endDate, String measurementUnit, List<PricingTier> priceTiers,List<Service> services, List<String> guaranteedPests) {
      this.companyName = comName;
      this.companyId = comId;
      this.name = name;
      this.displayName = displayName;
      this.planType = planType;
      this.serviceAreas = serviceAreas;
      this.coveredPropertyTypes = coveredPropertyTypes;
      this.serviceFrequency = serviceFrequency;
      this.billingFrequency = billingFrequency;
      this.billingFrequencyNotes = billingFrequencyNotes;
      this.startDate = startDate;
      this.endDate = endDate;
      this.measurementUnit = measurementUnit;
      this.priceTiers = priceTiers;
      this.services = services;

   }

   public Plan()
   {

   }

   private String companyName = "";

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public Integer getCompanyId() {
      return companyId;
   }

   public void setCompanyId(Integer companyId) {
      this.companyId = companyId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDisplayName() {
      return displayName;
   }

   public void setDisplayName(String displayName) {
      this.displayName = displayName;
   }

   public String getPlanType() {
      return planType;
   }

   public void setPlanType(String planType) {
      this.planType = planType;
   }

   public List<String> getServiceAreas() {
      return serviceAreas;
   }

   public void setServiceAreas(List<String> serviceAreas) {
      this.serviceAreas = serviceAreas;
   }

   public List<String> getCoveredPropertyTypes() {
      return coveredPropertyTypes;
   }

   public void setCoveredPropertyTypes(List<String> coveredPropertyTypes) {
      this.coveredPropertyTypes = coveredPropertyTypes;
   }

   public String getServiceFrequency() {
      return serviceFrequency;
   }

   public void setServiceFrequency(String serviceFrequency) {
      this.serviceFrequency = serviceFrequency;
   }

   public String getBillingFrequency() {
      return billingFrequency;
   }

   public void setBillingFrequency(String billingFrequency) {
      this.billingFrequency = billingFrequency;
   }

   public String getBillingFrequencyNotes() { return billingFrequencyNotes;}

   public void setBillingFrequencyNotes(String billingFrequencyNotes) { this.billingFrequencyNotes = billingFrequencyNotes;}

   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }

   public String getEndDate() {
      return endDate;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public String getMeasurementUnit() {
      return measurementUnit;
   }

   public void setMeasurementUnit(String measurementUnit) {
      this.measurementUnit = measurementUnit;
   }

   public List<PricingTier> getPriceTiers() {
      return priceTiers;
   }

   public void setPriceTiers(List<PricingTier> priceTiers) {
      this.priceTiers = priceTiers;
   }

   public List<Service> getServices() {
      return services;
   }

   public void setServices(List<Service> services) {
      this.services = services;
   }

}

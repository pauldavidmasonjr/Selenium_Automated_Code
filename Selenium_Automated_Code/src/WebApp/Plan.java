package WebApp;

import java.util.Date;
import java.util.List;

public class Plan {

   private String name = "";
   private String displayName = "";
   private String planType = "";
   private List<String> serviceAreas;
   private List<String> coveredPropertyTypes;
   private String serviceFrequency;
   private String billingFrequency;
   private Date startDate;
   private Date endDate;
   private String measurementUnit;
   private List<PricingTier> priceTiers;
   private List<String> coveredPests;
   private List<String> GuaranteedPests;

   public Plan(String name, String displayName, String planType, List<String> serviceAreas, List<String> coveredPropertyTypes, String serviceFrequency, String billingFrequency, Date startDate, Date endDate, String measurementUnit, List<PricingTier> priceTiers, List<String> coveredPests, List<String> guaranteedPests) {
      this.name = name;
      this.displayName = displayName;
      this.planType = planType;
      this.serviceAreas = serviceAreas;
      this.coveredPropertyTypes = coveredPropertyTypes;
      this.serviceFrequency = serviceFrequency;
      this.billingFrequency = billingFrequency;
      this.startDate = startDate;
      this.endDate = endDate;
      this.measurementUnit = measurementUnit;
      this.priceTiers = priceTiers;
      this.coveredPests = coveredPests;
      GuaranteedPests = guaranteedPests;
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

   public Date getStartDate() {
      return startDate;
   }

   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
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

   public List<String> getCoveredPests() {
      return coveredPests;
   }

   public void setCoveredPests(List<String> coveredPests) {
      this.coveredPests = coveredPests;
   }

   public List<String> getGuaranteedPests() {
      return GuaranteedPests;
   }

   public void setGuaranteedPests(List<String> guaranteedPests) {
      GuaranteedPests = guaranteedPests;
   }
}

package Objects.WebApp;

public class Service {

    private String serviceName;
    private Boolean guaranteed;

    public Service(String serviceName, Boolean guaranteed) {
        this.serviceName = serviceName;
        this.guaranteed = guaranteed;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(Boolean guaranteed) {
        this.guaranteed = guaranteed;
    }
}

public class Interface {

    private String name;
    private String ipAddress;
    private String description;
    private String speed;
    private String duplex;
    private String status;
    private String operationStatus;
    private String macAddress;
    private String mtu;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " \t interface name:" + name + "\n\t" +
                " ip address:" + ipAddress + "\n\t" +
                " interface description:" + description + "\n\t" +
                " ifSpeed:" + speed + "\n\t" +
                " duplex mode:" + duplex + "\n\t" +
                " admin status:" + status + "\n\t" +
                " operation status:" + operationStatus + "\n\t" +
                " mac address:" + macAddress + "\n\t" +
                " mtu:" + mtu + "\n\t";
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDuplex() {
        return duplex;
    }

    public void setDuplex(String duplex) {
        this.duplex = duplex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMtu() {
        return mtu;
    }

    public void setMtu(String mtu) {
        this.mtu = mtu;
    }
    }
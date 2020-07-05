package Camera;

public class CameraInfo {
    private String ip;
    private String name;
    private String login;
    private String password;
    private String timeLastUpdate;

    public String getTimeUpdate() {
        return timeLastUpdate;
    }

    public CameraInfo(String ip, String name, String login, String password) {
        this.ip = ip;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }
}

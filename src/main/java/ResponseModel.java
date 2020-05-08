import java.util.Map;

public class ResponseModel {
    public Map<String, String> args;
    public String data;
    public Map<String, String> files;
    public Map<String, String> form;
    public Map<String, String> headers;
    public Map<String, String> json;
    public String url;

    public ResponseModel() {
    }

    private String mapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map.isEmpty()) {
            return "{}";
        } else {
            int count = map.size();
            sb.append("{\n");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (count == 1) {
                    sb.append("          \"" + entry.getKey() + "\"=\"" + entry.getValue() + "\"\n");
                } else {
                    sb.append("          \"" + entry.getKey() + "\"=\"" + entry.getValue() + "\",\n");
                }
                count--;
            }
            sb.append("}");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "\nargs=" + mapToString(args) +
                "\n data='" + data + '\'' +
                "\n files=" + mapToString(files) +
                "\n form=" + mapToString(form) +
                "\n headers=" + mapToString(headers) +
                "\n json=" + mapToString(json) +
                "\n url='" + url + '\'' +
                '}';
    }
}

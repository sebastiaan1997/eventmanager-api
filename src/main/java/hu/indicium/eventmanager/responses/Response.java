package hu.indicium.eventmanager.responses;

public abstract class Response {
    private Object data;
    private Object error;

    public Response(Object data, Object error) {
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}

import java.util.function.Consumer;

public class Identifiers {
    private String cinNo;
    private String gstNo;
    private String panNo;

    public Identifiers with(
            Consumer<Identifiers> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cinNo == null) ? 0 : cinNo.hashCode());
        result = prime * result + ((gstNo == null) ? 0 : gstNo.hashCode());
        result = prime * result + ((panNo == null) ? 0 : panNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Identifiers other = (Identifiers) obj;
        if (this.cinNo == other.cinNo || this.gstNo == other.gstNo || this.panNo == other.panNo) {
            return true;
        }

        return false;
    }

    public String getCinNo() {
        return cinNo;
    }

    public void setCinNo(String cinNo) {
        this.cinNo = cinNo;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }



}
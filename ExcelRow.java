public class ExcelRow {
    private String corporteName;
    private String cinNo;
    private String gstNo;
    private String panNo;
    private Integer value;

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime;
    }

    

    @Override
    public String toString() {
        return "ExcelRow [corporteName=" + corporteName + ", cinNo=" + cinNo + ", gstNo=" + gstNo + ", panNo=" + panNo
                + ", value=" + value + "]";
    }



    public Integer getValue() {
        return value;
    }



    public void setValue(Integer value) {
        this.value = value;
    }



    @Override
    public boolean equals(Object obj) {
        ExcelRow other = (ExcelRow) obj;
        if ((this.corporteName == other.corporteName)
                      && ((!this.cinNo.isEmpty() && other.cinNo != null) && this.cinNo == other.cinNo
                        ||(this.gstNo != null && other.gstNo != null) && this.gstNo == other.gstNo 
                        ||(this.panNo != null && other.panNo != null) && this.panNo == other.panNo)) {
            return true;
        }
        return false;
    }

    public ExcelRow(String corporteName, String cinNo, String gstNo, String panNo,int value) {
        this.corporteName = corporteName;
        this.cinNo = cinNo;
        this.gstNo = gstNo;
        this.panNo = panNo;
        this.value = value;
    }

    public String getCorporteName() {
        return corporteName;
    }

    public void setCorporteName(String corporteName) {
        this.corporteName = corporteName;
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

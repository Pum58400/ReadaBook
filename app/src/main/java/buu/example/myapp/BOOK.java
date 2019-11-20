package buu.example.myapp;

public class BOOK {
 private String BOOKID;
    private String ANTHOR;
    private String PAGE;

    public BOOK() {
    }

    public BOOK(String BOOKID, String ANTHOR, String PAGE) {
        this.BOOKID = BOOKID;
        this.ANTHOR = ANTHOR;
        this.PAGE = PAGE;
    }

    public String getBOOKID() {
        return BOOKID;
    }

    public void setBOOKID(String BOOKID) {
        this.BOOKID = BOOKID;
    }

    public String getANTHOR() {
        return ANTHOR;
    }

    public void setANTHOR(String ANTHOR) {
        this.ANTHOR = ANTHOR;
    }

    public String getPAGE() {
        return PAGE;
    }

    public void setPAGE(String PAGE) {
        this.PAGE = PAGE;
    }
}

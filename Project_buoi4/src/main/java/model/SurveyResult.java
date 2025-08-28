package model;

public class SurveyResult {
    private final String firstName, lastName, email, dob, heardFrom, contactViaText;
    private final boolean wantsUpdates, emailOK;

    public SurveyResult(String firstName, String lastName, String email, String dob,
                        String heardFrom, boolean wantsUpdates, boolean emailOK, String contactViaText) {
        this.firstName = firstName; this.lastName = lastName; this.email = email;
        this.dob = dob; this.heardFrom = heardFrom; this.wantsUpdates = wantsUpdates;
        this.emailOK = emailOK; this.contactViaText = contactViaText;
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getEmail()     { return email; }
    public String getDob()       { return dob; }
    public String getHeardFrom() { return heardFrom; }
    public boolean isWantsUpdates() { return wantsUpdates; }
    public boolean isEmailOK()      { return emailOK; }
    public String getContactViaText(){ return contactViaText; }
}

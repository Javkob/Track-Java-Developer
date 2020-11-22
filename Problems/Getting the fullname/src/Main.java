class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }else{
            this.firstName = "";
        }
        // write your code here
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }else{
            this.lastName = "";
        }
        // write your code here
    }

    public String getFullName() {
        // .trim() A String value, which is a copy of the string, without leading and trailing whitespace
        String fullName = (firstName + " " + lastName).trim();
        return fullName.isEmpty() ? "Unknown" : fullName;
    }
}
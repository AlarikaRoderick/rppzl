package model;

import java.time.LocalDate;
import java.util.Objects;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private String gender;
    private String passportSeries;
    private String passportNumber;
    private String passportIssue;
    private LocalDate dateIssue;
    private String identicalNumber;
    private String birthPlace;
    private String livingCity;
    private String phoneHomeNumber;
    private String phoneNumber;
    private String email;
    private String maritalStatus;
    private String citizenship;
    private String disability;
    private String pensioner;
    private String monthlyIncome;
    private String military;

    public Client(){}

    public Client(String firstName, String lastName, String patronymic, LocalDate birthDate,
                  String gender, String passportSeries, String passportNumber, String passportIssue,
                  LocalDate dateIssue, String identicalNumber, String birthPlace, String livingCity,
                  String phoneHomeNumber, String phoneNumber, String email, String maritalStatus, String citizenship,
                  String disability, String pensioner, String monthlyIncome, String military) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.passportIssue = passportIssue;
        this.dateIssue = dateIssue;
        this.identicalNumber = identicalNumber;
        this.birthPlace = birthPlace;
        this.livingCity = livingCity;
        this.phoneHomeNumber = phoneHomeNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
        this.disability = disability;
        this.pensioner = pensioner;
        this.monthlyIncome = monthlyIncome;
        this.military = military;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssue() {
        return passportIssue;
    }

    public void setPassportIssue(String passportIssue) {
        this.passportIssue = passportIssue;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getIdenticalNumber() {
        return identicalNumber;
    }

    public void setIdenticalNumber(String identicalNumber) {
        this.identicalNumber = identicalNumber;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getLivingCity() {
        return livingCity;
    }

    public void setLivingCity(String livingCity) {
        this.livingCity = livingCity;
    }

    public String getPhoneHomeNumber() {
        return phoneHomeNumber;
    }

    public void setPhoneHomeNumber(String phoneHomeNumber) {
        this.phoneHomeNumber = phoneHomeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getPensioner() {
        return pensioner;
    }

    public void setPensioner(String pensioner) {
        this.pensioner = pensioner;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(patronymic, client.patronymic) &&
                Objects.equals(birthDate, client.birthDate) &&
                Objects.equals(gender, client.gender) &&
                Objects.equals(passportSeries, client.passportSeries) &&
                Objects.equals(passportNumber, client.passportNumber) &&
                Objects.equals(passportIssue, client.passportIssue) &&
                Objects.equals(dateIssue, client.dateIssue) &&
                Objects.equals(identicalNumber, client.identicalNumber) &&
                Objects.equals(birthPlace, client.birthPlace) &&
                Objects.equals(livingCity, client.livingCity) &&
                Objects.equals(phoneHomeNumber, client.phoneHomeNumber) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(email, client.email) &&
                Objects.equals(maritalStatus, client.maritalStatus) &&
                Objects.equals(citizenship, client.citizenship) &&
                Objects.equals(disability, client.disability) &&
                Objects.equals(pensioner, client.pensioner) &&
                Objects.equals(monthlyIncome, client.monthlyIncome) &&
                Objects.equals(military, client.military);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, birthDate,
                gender, passportSeries, passportNumber, passportIssue,
                dateIssue, identicalNumber, birthPlace, livingCity,
                phoneHomeNumber, phoneNumber, email, maritalStatus,
                citizenship, disability, pensioner, monthlyIncome, military);
    }
}

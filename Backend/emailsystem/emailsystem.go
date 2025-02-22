package main

import (
	"bytes"
	"fmt"
	"gopkg.in/gomail.v2"
	"os"
	"text/template"
)

func main() {
	// Dane nadawcy
	from := "mmailsystem@gmail.com"
	password := os.Getenv("GO_MAIL_SYSTEM_PASSWD")

	// Adresy odbiorców
	to := []string{
		"piotr.gorszy@interia.pl",
	}

	// Konfiguracja serwera SMTP
	smtpHost := "smtp.gmail.com"
	smtpPort := 587

	// Parsowanie szablonu HTML
	tmpl, err := template.ParseFiles("./templates/greeting_mail.html")
	if err != nil {
		fmt.Println("Błąd parsowania szablonu:", err)
		return
	}

	var body bytes.Buffer
	err = tmpl.Execute(&body, struct {
		Name    string
		Message string
	}{
		Name:    "Tytus Bomba",
		Message: "Welcome in our society!",
	})
	if err != nil {
		fmt.Println("Błąd wykonania szablonu:", err)
		return
	}

	// Tworzenie wiadomości e-mail
	m := gomail.NewMessage()
	m.SetHeader("From", from)
	m.SetHeader("To", to...)
	m.SetHeader("Subject", "Welcome message")
	//m.SetBody("text/plain", "Welcome in our society!")
	m.SetBody("text/html", body.String())

	// Konfiguracja dialera SMTP
	d := gomail.NewDialer(smtpHost, smtpPort, from, password)

	// Wysłanie wiadomości
	if err := d.DialAndSend(m); err != nil {
		fmt.Println("Błąd wysyłania maila:", err)
		return
	}

	fmt.Println("Email wysłany!")
}

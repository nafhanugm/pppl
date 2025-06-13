@login
Feature: Login Authorization
  As a registered user
  I want to login to the Nutribox system
  So that I can access my account

  Background:
    Given user sudah masuk ke halaman login

  Scenario: User berhasil login dengan kredensial yang valid
    Given user berada di halaman login
    When user memasukkan email "Cek123456@gmail.com"
    And user memasukkan password "Cek123456@gmail.com"
    And user klik tombol "Next"
    Then data email dan password akan terverifikasi
    And halaman pengisian token muncul

  Scenario: User gagal login dengan email atau password yang salah
    Given user berada di halaman login
    When user memasukkan email "salah@domain.com"
    And user memasukkan password "passwordsalah"
    And user klik tombol "Next"
    Then pesan kesalahan "Invalid email or password" muncul
@token
Feature: Pengisian Token
  As a registered user
  I want to fill in a token
  So that I can access my account

  Background:
    Given user sudah berhasil login dan berada di halaman pengisian token

  # Skenario Negatif: User mengisi token yang invalid
  Scenario: User mengisi token yang invalid
    Given user mengisi token yang invalid "INVALID123"
    When user klik tombol "Submit"
    Then pesan kesalahan "Token tidak valid" muncul

  # Skenario Positif: User mengisi token yang valid
  Scenario: User mengisi token yang valid
    Given user mengisi token yang valid "indomie1234"
    When user klik tombol "Submit"
    Then token akan terverifikasi dan user berhasil masuk ke halaman utama

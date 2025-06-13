@weight
Feature: Create, Edit, and Delete Berat Badan
  As a registered user
  I want to manage my weight data
  So that I can track my BMI

  Background:
    Given user sudah berhasil login dan berada di halaman statistik berat badan
    And user sudah memiliki 1 data berat badan

  # Scenario 1: Create or Input Weight with Valid Input (Positive)
  Scenario: User mengisi form dengan input angka valid untuk berat dan tinggi badan
    Given user klik tombol "Tambah Data"
    And user mengisi form untuk menambah rekaman data berat dan tinggi badan dengan input angka 1
    When user klik tombol "Submit" pada tambah
    Then berat badan dan tinggi badan berhasil ditambahkan

  # Scenario 2: Create or Input Weight with Invalid Input -1 (Negative)
  Scenario: User mengisi form dengan input angka -1 untuk berat dan tinggi badan
    Given user klik tombol "Tambah Data"
    And user mengisi form untuk menambah rekaman data berat dan tinggi badan dengan input angka -1
    When user klik tombol "Submit" pada tambah
    Then pesan kesalahan "Data tidak valid" muncul

  # Scenario 3: Create or Input Weight with Invalid Input 501 (Negative)
  Scenario: User mengisi form dengan input angka 501 untuk berat badan dan tinggi badan
    Given user klik tombol "Tambah Data"
    And user mengisi form untuk menambah rekaman data berat dan tinggi badan dengan input angka 501
    When user klik tombol "Submit" pada tambah
    Then pesan kesalahan "Data tidak valid" muncul

  # Scenario 4: Edit Weight Data with Valid Input (Positive)
  Scenario: User mengedit data berat badan dengan input angka valid
    Given user klik tombol "Edit" dengan ikon pensil di data berat badan paling atas
    And user mengisi form untuk mengedit rekaman data berat dan tinggi badan dengan input angka 2
    When user klik tombol "Submit" pada edit
    Then data berat badan dan tinggi badan berhasil diperbarui

  # Scenario 5: Edit Weight Data with Invalid Input -1 (Negative)
  Scenario: User mengedit data berat badan dengan input angka -1
    Given user klik tombol "Edit" dengan ikon pensil di data berat badan paling atas
    And user mengisi form untuk mengedit rekaman data berat dan tinggi badan dengan input angka -1
    When user klik tombol "Submit" pada edit
    Then pesan kesalahan "Data tidak valid" muncul

  # Scenario 6: Delete Weight Data
  Scenario: User menghapus data berat badan
    Given user klik tombol "Hapus" di data berat badan
    When user klik tombol "Hapus" pada popup konfirmasi yang muncul
    Then data berat badan berhasil dihapus

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Des 2019 pada 16.47
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`username`, `password`) VALUES
('admin', 'test');

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `Kode_Barang` varchar(50) NOT NULL,
  `Nama_Barang` varchar(50) NOT NULL,
  `Berat` int(11) NOT NULL,
  `Harga` double NOT NULL,
  `Stok_Barang` int(11) NOT NULL,
  `No_Rak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`Kode_Barang`, `Nama_Barang`, `Berat`, `Harga`, `Stok_Barang`, `No_Rak`) VALUES
('P1', 'Aqua Gelas 240ml', 4, 500, 480, 48),
('P2', 'Roti Cocola Coklat', 50, 2000, 128, 24),
('P3', 'Teh Pucuk Harum 350ml', 400, 3000, 240, 3),
('P4', 'Mizone Apple Guava 600ml', 350, 3500, 320, 18),
('P5', 'Gudang Garam Surya 12', 140, 15000, 96, 12),
('P6', 'Esse', 90, 500, 213, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailpengadaan`
--

CREATE TABLE `detailpengadaan` (
  `idPengadaan` varchar(50) NOT NULL,
  `Kode_Barang` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detailpengadaan`
--

INSERT INTO `detailpengadaan` (`idPengadaan`, `Kode_Barang`, `Jumlah`, `Harga`, `Total`) VALUES
('PO1', 'P1', 30, 400, 12000),
('PO2', 'P5', 30, 14000, 420000),
('PO3', 'P3', 50, 2800, 140000),
('PO4', 'P2', 30, 1750, 52500),
('PO5', 'P1', 20, 400, 8000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengadaan`
--

CREATE TABLE `pengadaan` (
  `idPengadaan` varchar(50) NOT NULL,
  `tanggalPengadaan` date NOT NULL,
  `totalPengadaan` int(11) NOT NULL,
  `statusPengadaan` varchar(50) NOT NULL,
  `id_Supplier` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengadaan`
--

INSERT INTO `pengadaan` (`idPengadaan`, `tanggalPengadaan`, `totalPengadaan`, `statusPengadaan`, `id_Supplier`) VALUES
('PO1', '2016-12-19', 432000, 'Waiting', 'SUP1'),
('PO2', '2016-12-19', 200500, 'Waiting', 'SUP2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `id_Supplier` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `No_Telp` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`id_Supplier`, `nama`, `jenis`, `alamat`, `No_Telp`) VALUES
('SUP1', 'Mamank', 'Person', 'kenjeran', 2147483647),
('SUP2', 'Racing', 'Person', 'sukabirus', 2147483647),
('SUP3', 'Jwalita', 'Company', 'kiara condong', 2147483647);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` varchar(50) NOT NULL,
  `tanggalTransaksi` date NOT NULL,
  `waktuTransaksi` time NOT NULL,
  `totalTransaksi` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `tanggalTransaksi`, `waktuTransaksi`, `totalTransaksi`) VALUES
('TR1', '2016-12-18', '20:17:29', 15000),
('TR2', '2016-12-20', '07:00:00', 16000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Kode_Barang`);

--
-- Indeks untuk tabel `detailpengadaan`
--
ALTER TABLE `detailpengadaan`
  ADD PRIMARY KEY (`idPengadaan`);

--
-- Indeks untuk tabel `pengadaan`
--
ALTER TABLE `pengadaan`
  ADD PRIMARY KEY (`idPengadaan`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_Supplier`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `idTransaksi` (`idTransaksi`,`tanggalTransaksi`,`waktuTransaksi`,`totalTransaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

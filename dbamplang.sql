-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2023 at 02:37 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbamplang`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbakun`
--

CREATE TABLE `tbakun` (
  `ID` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbakun`
--

INSERT INTO `tbakun` (`ID`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'ikhwan', '066');

-- --------------------------------------------------------

--
-- Table structure for table `tbamplang`
--

CREATE TABLE `tbamplang` (
  `ID` int(11) NOT NULL,
  `Rasa` varchar(255) NOT NULL,
  `Ukuran` varchar(255) NOT NULL,
  `Stok` int(255) NOT NULL,
  `Umur Simpan` varchar(255) NOT NULL,
  `Harga` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbamplang`
--

INSERT INTO `tbamplang` (`ID`, `Rasa`, `Ukuran`, `Stok`, `Umur Simpan`, `Harga`) VALUES
(1, 'Ikan Tenggiri', '150 Gram', 220, '20 Hari', 25000),
(3, 'Kepiting', '80 Gram', 170, '10 Hari', 20000),
(4, 'Ikan Gabus', '150 Gram', 190, '20 Hari', 19500),
(8, 'Ikan Belida', '150 Gram', 150, '25 Hari', 26000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbakun`
--
ALTER TABLE `tbakun`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbamplang`
--
ALTER TABLE `tbamplang`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbakun`
--
ALTER TABLE `tbakun`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbamplang`
--
ALTER TABLE `tbamplang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

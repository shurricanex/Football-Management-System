-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2019 at 04:35 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fms`
--

-- --------------------------------------------------------

--
-- Table structure for table `teamleader`
--

CREATE TABLE `teamleader` (
  `tid` int(11) NOT NULL,
  `team_name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phonenumber` int(11) NOT NULL,
  `sponsor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teamleader`
--

INSERT INTO `teamleader` (`tid`, `team_name`, `username`, `password`, `phonenumber`, `sponsor`) VALUES
(1, 'qweqwe', 'asdasd', '1', 1233, NULL),
(2, '123', 'a', 'abc', 123, NULL),
(3, 'qweqwe', 'hello', 'abc', 123, NULL),
(4, 'aa1', 'senghok', 'abc123', 2123456, NULL),
(5, 'asdads', 'aa1', 'aa1', 123, NULL),
(6, '55123', 'ab55', '123', 12355, NULL),
(7, '6trereer', 'jinng', 'asdasdasd', 6612355, NULL),
(8, 'Kiii1', 'sievly', 'appoo', 1295839, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `teamleader`
--
ALTER TABLE `teamleader`
  ADD PRIMARY KEY (`tid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `teamleader`
--
ALTER TABLE `teamleader`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

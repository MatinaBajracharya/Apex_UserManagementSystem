-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2020 at 04:21 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usermanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `activity` varchar(20) NOT NULL,
  `date` datetime DEFAULT current_timestamp(),
  `new_user` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `user_id`, `activity`, `date`, `new_user`) VALUES
(312, 35, 'LOGIN', '2020-06-08 18:44:52', NULL),
(313, 35, 'LOGIN', '2020-06-08 19:15:17', NULL),
(314, 35, 'UPDATED_PROFILE', '2020-06-08 19:15:45', NULL),
(315, 35, 'PASSWORD_CHANGE', '2020-06-08 19:16:19', NULL),
(316, 35, 'LOGIN', '2020-06-08 19:17:51', NULL),
(317, 35, 'LOGIN', '2020-06-08 19:23:25', NULL),
(318, 35, 'ADDED_USER', '2020-06-08 19:25:17', 'matinabajra.13@gmail.com'),
(319, 35, 'LOGIN', '2020-06-08 19:29:02', NULL),
(320, 35, 'LOGIN', '2020-06-08 19:30:28', NULL),
(321, 71, 'REGISTERED', '2020-06-08 19:33:14', NULL),
(322, 71, 'LOGIN', '2020-06-08 19:34:19', NULL),
(323, 71, 'UPDATED_PROFILE', '2020-06-08 19:34:48', NULL),
(324, 71, 'PASSWORD_CHANGE', '2020-06-08 19:35:52', NULL),
(325, 71, 'LOGIN', '2020-06-08 19:36:00', NULL),
(326, 71, 'LOGIN', '2020-06-08 19:37:49', NULL),
(327, 71, 'LOGIN', '2020-06-08 19:43:00', NULL),
(328, 71, 'LOGIN', '2020-06-08 19:44:46', NULL),
(329, 71, 'LOGIN', '2020-06-08 19:46:37', NULL),
(330, 71, 'LOGIN', '2020-06-08 20:01:41', NULL),
(331, 35, 'LOGIN', '2020-06-08 20:02:06', NULL),
(332, 35, 'LOGIN', '2020-06-08 20:04:19', NULL),
(333, 35, 'UPDATED_USER', '2020-06-08 20:05:10', 'karma@gmail.com'),
(334, 71, 'PASSWORD_RESET', '2020-06-08 20:05:58', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `middle_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `security_ans1` varchar(15) NOT NULL,
  `security_ans2` varchar(15) NOT NULL,
  `role` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `middle_name`, `last_name`, `email`, `password`, `security_ans1`, `security_ans2`, `role`, `status`) VALUES
(35, 'super ', '', 'user', 'super@user.com', 'test1234', 'test', 'test', 'ADMIN', 'ACTIVE'),
(70, 'Matina', '', 'Bajracharya', 'matinabajra.13@gmail.com', 'matina1234', 'Kathmandu', 'Bruno', 'CLIENT', 'ACTIVE'),
(71, 'Karma', 'Dolma', 'Gurung', 'karma@gmail.com', 'karma1234', 'Kathmandu', 'Cooper', 'CLIENT', 'ACTIVE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=335;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

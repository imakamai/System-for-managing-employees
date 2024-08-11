-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2024 at 08:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `date_employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `registration_number` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `lastname`, `email`, `registration_number`, `password`) VALUES
(6, 'John', 'Doe', 'john.doe@example.com', 123456, '$2a$12$qMgL6v6nkE6ljAduP7Ekz.hH8czNFdYihe1Rs/gQBnby8phMGRsg6'),
(7, 'Jane', 'Smith', 'jane.smith@example.com', 654321, '$2a$12$qMgL6v6nkE6ljAduP7Ekz.hH8czNFdYihe1Rs/gQBnby8phMGRsg6'),
(8, 'Alice', 'Johnson', 'alice.johnson@example.com', 112233, '$2a$12$qMgL6v6nkE6ljAduP7Ekz.hH8czNFdYihe1Rs/gQBnby8phMGRsg6\r\n'),
(9, 'Bob', 'Brown', 'bob.brown@example.com', 332211, '$2a$12$qMgL6v6nkE6ljAduP7Ekz.hH8czNFdYihe1Rs/gQBnby8phMGRsg6'),
(10, 'Charlie', 'Davis', 'charlie.davis@example.com', 445566, '$2a$12$qMgL6v6nkE6ljAduP7Ekz.hH8czNFdYihe1Rs/gQBnby8phMGRsg6'),
(11, 'Vanja', 'Cekic', 'vanja@gmail.com', 123456789, '$2a$11$IVp7q.eI41tcq6RFHA7ysujAXbErBLUD/x3DTEa/PK3qExa6L6OkO');

-- --------------------------------------------------------

--
-- Table structure for table `employee_leave`
--

CREATE TABLE `employee_leave` (
  `employee_leave_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `leave_id` int(11) DEFAULT NULL,
  `leave_request` text DEFAULT NULL,
  `leave_request_date` date DEFAULT NULL,
  `is_approved` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_leave`
--

INSERT INTO `employee_leave` (`employee_leave_id`, `employee_id`, `leave_id`, `leave_request`, `leave_request_date`, `is_approved`) VALUES
(1, 7, 1, 'Zahtev za bolovanje zbog bolesti.', '2024-06-07', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_position`
--

CREATE TABLE `employee_position` (
  `employee_position_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_position`
--

INSERT INTO `employee_position` (`employee_position_id`, `employee_id`, `position_id`) VALUES
(6, 8, 1),
(7, 9, 3),
(8, 7, 5),
(9, 6, 2),
(12, 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_role`
--

CREATE TABLE `employee_role` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_role`
--

INSERT INTO `employee_role` (`id`, `employee_id`, `role_id`) VALUES
(1, 11, 1),
(2, 7, 2);

-- --------------------------------------------------------

--
-- Table structure for table `leave_table`
--

CREATE TABLE `leave_table` (
  `leave_id` int(11) NOT NULL,
  `leaveType` enum('SICK_LEAVE','STATE_HOLIDAY','VACATION','MATERNITY') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_table`
--

INSERT INTO `leave_table` (`leave_id`, `leaveType`) VALUES
(1, 'SICK_LEAVE'),
(2, 'STATE_HOLIDAY'),
(3, 'VACATION'),
(4, 'MATERNITY');

-- --------------------------------------------------------

--
-- Table structure for table `position_info`
--

CREATE TABLE `position_info` (
  `position_id` int(11) NOT NULL,
  `positionType` enum('CEO',' DIRECTOR',' MANAGER','FRONTEND_DEVELOPER',' BACKEND_DEVELOPER','DESIGNER_DEVELOPER') NOT NULL,
  `mothly_working_hours` int(11) NOT NULL,
  `salary_per_hour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `position_info`
--

INSERT INTO `position_info` (`position_id`, `positionType`, `mothly_working_hours`, `salary_per_hour`) VALUES
(1, 'CEO', 160, 50),
(2, ' MANAGER', 160, 40),
(3, ' DIRECTOR', 160, 35),
(4, ' BACKEND_DEVELOPER', 160, 30),
(5, 'FRONTEND_DEVELOPER', 160, 28),
(6, 'DESIGNER_DEVELOPER', 160, 25);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_type` enum('ADMIN','USER','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_type`) VALUES
(1, 'ADMIN'),
(2, 'USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `employee_leave`
--
ALTER TABLE `employee_leave`
  ADD PRIMARY KEY (`employee_leave_id`),
  ADD KEY `fk_employee_id` (`employee_id`),
  ADD KEY `fk_leave_id` (`leave_id`);

--
-- Indexes for table `employee_position`
--
ALTER TABLE `employee_position`
  ADD PRIMARY KEY (`employee_position_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `position_id` (`position_id`);

--
-- Indexes for table `employee_role`
--
ALTER TABLE `employee_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `leave_table`
--
ALTER TABLE `leave_table`
  ADD PRIMARY KEY (`leave_id`);

--
-- Indexes for table `position_info`
--
ALTER TABLE `position_info`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `employee_leave`
--
ALTER TABLE `employee_leave`
  MODIFY `employee_leave_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employee_position`
--
ALTER TABLE `employee_position`
  MODIFY `employee_position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `employee_role`
--
ALTER TABLE `employee_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `leave_table`
--
ALTER TABLE `leave_table`
  MODIFY `leave_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `position_info`
--
ALTER TABLE `position_info`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_leave`
--
ALTER TABLE `employee_leave`
  ADD CONSTRAINT `fk_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `fk_leave_id` FOREIGN KEY (`leave_id`) REFERENCES `leave_table` (`leave_id`);

--
-- Constraints for table `employee_position`
--
ALTER TABLE `employee_position`
  ADD CONSTRAINT `employee_position_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `employee_position_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position_info` (`position_id`);

--
-- Constraints for table `employee_role`
--
ALTER TABLE `employee_role`
  ADD CONSTRAINT `employee_role_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `employee_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

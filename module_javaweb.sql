-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th3 28, 2022 lúc 05:05 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `module_javaweb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `position`
--

CREATE TABLE `position` (
  `id` int(11) NOT NULL,
  `position` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `position`
--

INSERT INTO `position` (`id`, `position`) VALUES
(1, 'intern'),
(2, 'student'),
(3, 'teacher');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `id_position` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `address`, `age`, `phone`, `image`, `id_position`) VALUES
(2, 'hai long', 'hai phong ', 23, '0964237111', 'avatar02.png', 1),
(3, 'hai hong', 'nghe an', 22, '0964237111', 'avatar03.jpeg', 2),
(5, 'hai bong', 'hai phong', 19, '0964237111', 'avatar04.png', 3),
(8, 'phong', 'ha noi', 21, '0964237030', 'avatar05.jpeg', 1),
(11, 'phong', 'ha nam ', 25, '0964237111', 'avatar06.png', 1),
(17, 'phong', 'ha long', 21, '123321123321', 'avatar02.png', 1),
(18, 'phong', 'ha nam', 21, '0964237030', 'avatar05.jpeg', 2),
(27, 'phong', 'ha long ', 21, '0964237030', 'avatar01.png', 1),
(28, 'phong', 'ha noi', 21, '123321123321', 'avatar06.png', 2),
(29, 'hai phong', 'HÃ  Ná»i', 19, '123321123321', 'avatar04.png', 3),
(30, 'hai phong', 'ha noi', 21, '0964237111', 'avatar05.jpeg', 2),
(31, 'phong', 'hai phong', 18, '0964237111', 'avatar05.jpeg', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_position` (`id_position`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `position`
--
ALTER TABLE `position`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_position`) REFERENCES `position` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

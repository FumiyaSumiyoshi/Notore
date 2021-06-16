-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2021-06-16 05:34:51
-- サーバのバージョン： 10.4.18-MariaDB
-- PHP のバージョン: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `notore`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `administrator`
--

CREATE TABLE `administrator` (
  `id` int(10) UNSIGNED NOT NULL,
  `login_id` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creater_id` int(10) UNSIGNED DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updater_id` int(10) UNSIGNED DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `administrator`
--

INSERT INTO `administrator` (`id`, `login_id`, `creater_id`, `create_date`, `updater_id`, `update_date`, `deleted`) VALUES
(1, 'ABC2', 2, '2021-06-16 11:44:15', 2, '2021-06-16 11:44:15', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `category`
--

CREATE TABLE `category` (
  `id` int(10) UNSIGNED NOT NULL,
  `category` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creater_id` int(10) UNSIGNED DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updater_id` int(10) UNSIGNED DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `category`
--

INSERT INTO `category` (`id`, `category`, `creater_id`, `create_date`, `updater_id`, `update_date`, `deleted`) VALUES
(1, '国語', 34, '2021-06-16 12:25:41', 34, '2021-06-16 12:25:41', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `level`
--

CREATE TABLE `level` (
  `id` int(10) UNSIGNED NOT NULL,
  `level` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creater_id` int(10) UNSIGNED DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updater_id` int(10) UNSIGNED DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `level`
--

INSERT INTO `level` (`id`, `level`, `creater_id`, `create_date`, `updater_id`, `update_date`, `deleted`) VALUES
(1, 'やさしい', 34, '2021-06-16 12:28:12', 34, '2021-06-16 12:28:12', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `question`
--

CREATE TABLE `question` (
  `id` int(10) UNSIGNED NOT NULL,
  `question` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int(10) UNSIGNED DEFAULT NULL,
  `level_id` int(10) UNSIGNED DEFAULT NULL,
  `answer_form` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point` smallint(6) DEFAULT NULL,
  `answer` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coment` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creater_id` int(10) UNSIGNED DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `updater_id` int(10) UNSIGNED DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `question`
--

INSERT INTO `question` (`id`, `question`, `category_id`, `level_id`, `answer_form`, `point`, `answer`, `coment`, `creater_id`, `create_date`, `updater_id`, `update_date`, `deleted`) VALUES
(1, '1 + 1 = ?', 5, 3, '単一選択', 15, '2', 'たしざんの基本', 23, '2021-06-16 12:31:32', 17, '2021-06-16 12:31:32', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `login_id` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_id` int(10) UNSIGNED DEFAULT NULL,
  `answer` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `user`
--

INSERT INTO `user` (`id`, `login_id`, `name_id`, `answer`, `answer_date`, `deleted`) VALUES
(1, 'TARO', 22, '2', '2021-06-16 12:18:06', 0);

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `administrator`
--
ALTER TABLE `administrator`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `category`
--
ALTER TABLE `category`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `level`
--
ALTER TABLE `level`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `question`
--
ALTER TABLE `question`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

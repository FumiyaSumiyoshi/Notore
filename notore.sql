-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2021-06-16 03:45:51
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
  `ID` int(10) UNSIGNED NOT NULL,
  `LoginID` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreaterID` int(10) UNSIGNED DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdaterID` int(10) UNSIGNED DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `Deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `administrator`
--

INSERT INTO `administrator` (`ID`, `LoginID`, `CreaterID`, `CreateDate`, `UpdaterID`, `UpdateDate`, `Deleted`) VALUES
(1, 'ABC1', 1, '2021-06-09 17:42:39', 1, '2021-06-09 17:42:39', 0),
(2, 'ABC2', 2, '2021-06-09 19:00:13', 2, '2021-06-09 19:00:13', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `category`
--

CREATE TABLE `category` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Category` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreaterID` int(10) UNSIGNED DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdaterID` int(10) UNSIGNED DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `Deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `category`
--

INSERT INTO `category` (`ID`, `Category`, `CreaterID`, `CreateDate`, `UpdaterID`, `UpdateDate`, `Deleted`) VALUES
(1, '国語', 34, '2021-06-10 00:47:13', 34, '2021-06-10 00:47:13', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `level`
--

CREATE TABLE `level` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Level` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreaterID` int(10) UNSIGNED DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdaterID` int(10) UNSIGNED DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `Deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `level`
--

INSERT INTO `level` (`ID`, `Level`, `CreaterID`, `CreateDate`, `UpdaterID`, `UpdateDate`, `Deleted`) VALUES
(1, 'やさしい', 34, '2021-06-10 00:51:23', 34, '2021-06-10 00:51:23', 0);

-- --------------------------------------------------------

--
-- テーブルの構造 `question`
--

CREATE TABLE `question` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Question` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CategoryID` int(10) UNSIGNED DEFAULT NULL,
  `LevelID` int(10) UNSIGNED DEFAULT NULL,
  `AnswerFORM` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Point` smallint(6) DEFAULT NULL,
  `Answer` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Coment` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreaterID` int(10) UNSIGNED DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdaterID` int(10) UNSIGNED DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `Deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- テーブルの構造 `user`
--

CREATE TABLE `user` (
  `ID` int(10) UNSIGNED NOT NULL,
  `LoginID` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NameID` int(10) UNSIGNED DEFAULT NULL,
  `Answer` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AnswerDate` datetime DEFAULT NULL,
  `Deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- テーブルのデータのダンプ `user`
--

INSERT INTO `user` (`ID`, `LoginID`, `NameID`, `Answer`, `AnswerDate`, `Deleted`) VALUES
(1, 'TARO', 22, '2', '2021-06-10 00:37:58', 0);

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`ID`);

--
-- テーブルのインデックス `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- テーブルのインデックス `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`ID`);

--
-- テーブルのインデックス `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`ID`);

--
-- テーブルのインデックス `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `administrator`
--
ALTER TABLE `administrator`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- テーブルの AUTO_INCREMENT `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `level`
--
ALTER TABLE `level`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- テーブルの AUTO_INCREMENT `question`
--
ALTER TABLE `question`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- テーブルの AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

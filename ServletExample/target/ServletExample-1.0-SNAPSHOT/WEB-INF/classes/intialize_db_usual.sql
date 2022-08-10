            DROP SCHEMA IF EXISTS `schema_name`;
	    CREATE DATABASE  IF NOT EXISTS `schema_name` DEFAULT CHARACTER SET utf8;
	    USE `schema_name`;
	    DROP TABLE IF EXISTS `answers`;
	    DROP TABLE IF EXISTS `questions`;
	    DROP TABLE IF EXISTS `rights`;
	    DROP TABLE IF EXISTS `users`;
	    CREATE TABLE `questions` (
		    `id_question` int(11) NOT NULL AUTO_INCREMENT,
		    `theme` varchar(45) NOT NULL DEFAULT 'n/a',
		    PRIMARY KEY (`id_question`)
		    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
	    CREATE TABLE `answers` (
		    `id_answer` int(11) NOT NULL AUTO_INCREMENT,
		    `text` varchar(45) NOT NULL,
		    `fk_question` int(11) NOT NULL,
		    `correct` tinyint(1) DEFAULT '0',
		    PRIMARY KEY (`id_answer`),
		    KEY `fk_answers_questions1_idx` (`fk_question`),
		    CONSTRAINT `fk_answers_questions1` FOREIGN KEY (`fk_question`) REFERENCES `questions` (`id_question`) ON DELETE NO ACTION ON UPDATE NO ACTION
		    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
	    CREATE TABLE `users` (
		    `id_user` int(11) NOT NULL AUTO_INCREMENT,
		    `name` varchar(45) NOT NULL,
		    `login` varchar(45) NOT NULL,
		    `password` varchar(45) NOT NULL,
		    `fk_question` int(11) NOT NULL,
		    `fk_right` int(11) NOT NULL,
		    PRIMARY KEY (`id_user`),
		    KEY `fk_users_questions1_idx` (`fk_question`),
		    CONSTRAINT `fk_users_questions1` FOREIGN KEY (`fk_question`) REFERENCES `questions` (`id_question`) ON DELETE NO ACTION ON UPDATE NO ACTION
		    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
	    CREATE TABLE `rights` (
		    `admin` tinyint(4) NOT NULL DEFAULT '0',
		    `user` tinyint(4) NOT NULL DEFAULT '0',
		    `guest` tinyint(4) NOT NULL DEFAULT '0',
		    `id_right` int(11) NOT NULL AUTO_INCREMENT,
		    PRIMARY KEY (`id_right`),
		    CONSTRAINT `fk_rights_users1` FOREIGN KEY (`id_right`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
		    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
	    INSERT INTO `questions` VALUES (1,'Вводная тема'),(2,'Общие положения'),(3,'Техника безопасности');
	    INSERT INTO `users` VALUES ('1','User1','Login1','Password1','1','1');
	    INSERT INTO `rights` VALUES (1,1,1,1);
	    INSERT INTO `answers` (`id_answer`, `text`, `fk_question`, `correct`) VALUES ('1', 'AnswerText 1', '1', '0');
	    INSERT INTO `answers` (`id_answer`, `text`, `fk_question`, `correct`) VALUES ('2', 'AnswerText 2', '1', '0');
	    INSERT INTO `answers` (`id_answer`, `text`, `fk_question`, `correct`) VALUES ('3', 'AnswerText 3', '1', '1');
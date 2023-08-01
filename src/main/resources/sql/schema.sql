DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `apply`;
DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `tel` varchar(255) NOT NULL,
                        `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        `delete_date` TIMESTAMP DEFAULT NULL,
                        `update_date` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`),
                        UNIQUE (username)
);

CREATE TABLE `user_role` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NOT NULL,
                             `role` varchar(255) NOT NULL,
                             `create_date` datetime(6) NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKsn0101oegd6lsfnumn271ch3i` (`user_id`),
                             CONSTRAINT check_role CHECK (role IN ('ADMIN', 'USER'))
);

CREATE TABLE `post` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `title` varchar(255) NOT NULL,
                        `category` varchar(255) NOT NULL,
                        `content` varchar(255) NOT NULL,
                        `user_id` int(11) NOT NULL,
                        `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        `delete_date` TIMESTAMP DEFAULT NULL,
                        `update_date` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`),
                        KEY `FKsi7h4ol2rnnnx4go14elpv3j5` (`user_id`),
                        CONSTRAINT `FKsi7h4ol2rnnnx4go14elpv3j5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `apply` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `title` varchar(255) NOT NULL,
                         `content` varchar(255) NOT NULL,
                         `post_id` int(11) NOT NULL,
                         `user_id` int(11) NOT NULL,
                         `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `delete_date` TIMESTAMP DEFAULT NULL,
                         `update_date` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`),
                         KEY `FKgk75f314pkgbx856cmuvcqkce` (`post_id`),
                         KEY `FKmcv2swjk2u76ambehmhundicw` (`user_id`),
                         CONSTRAINT `FKgk75f314pkgbx856cmuvcqkce` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
                         CONSTRAINT `FKmcv2swjk2u76ambehmhundicw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `comment` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `content` varchar(255) NOT NULL,
                           `user_id` int(11) NOT NULL,
                           `apply_id` int(11) NOT NULL,
                           `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `delete_date` TIMESTAMP DEFAULT NULL,
                           `update_date` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (`id`),
                           KEY `FK4oi5il6naumtqptyemxbnshog` (`apply_id`),
                           KEY `FKb2ja7paeb2wr0dja38ybmo79o` (`user_id`),
                           CONSTRAINT `FK4oi5il6naumtqptyemxbnshog` FOREIGN KEY (`apply_id`) REFERENCES `apply` (`id`),
                           CONSTRAINT `FKb2ja7paeb2wr0dja38ybmo79o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `review` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `content` varchar(255) NOT NULL,
                          `post_id` int(11) NOT NULL,
                          `user_id` int(11) NOT NULL,
                          `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          `delete_date` TIMESTAMP DEFAULT NULL,
                          `update_date` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (`id`),
                          KEY `FKkw565f2wvit2cag1vfaa5md2h` (`post_id`),
                          KEY `FKc634j2fciat0gow1yl0j9u35r` (`user_id`),
                          CONSTRAINT `FKc634j2fciat0gow1yl0j9u35r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                          CONSTRAINT `FKkw565f2wvit2cag1vfaa5md2h` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

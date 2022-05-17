CREATE TABLE IF NOT EXISTS `landlords`
(
   `LandlordId`    INT        NOT NULL,
   `Name`          VARCHAR    DEFAULT NULL,
   `PhoneNo`       VARCHAR(100) DEFAULT NULL,
   `Email`         VARCHAR(100) DEFAULT NULL,
   `PlotName`      VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`LandlordId` ),
    UNIQUE KEY `LandlordId` (`LandlordId` )
)
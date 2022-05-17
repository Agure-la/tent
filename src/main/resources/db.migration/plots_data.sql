CREATE TABLE IF NOT EXISTS `plots`
(
  `PlotNo`            INT       NOT NULL,
  `PlotName`          VARCHAR   NOT NULL,
  `NumberOfFloors`    INT       DEFAULT 0,
  `Description`       VARCHAR   DEFAULT NULL,
  `NumberOfRooms`     VARCHAR   DEFAULT NULL,
  `location`          VARCHAR   DEFAULT NULL,
  `RoomStatus`        VARCHAR   DEFAULT 'NO' NOT NULL,
  PRIMARY KEY (`PlotNo`),
  UNIQUE KEY `PlotNo` (`PlotNo`)
)
CREATE TABLE IF NOT EXISTS `plot_tenants`
(
`RegNo`        int(5)      NOT NULL DEFAULT 0,
`TenantName`   varchar(200) NOT NULL,
`RegDate`      datetime     DEFAULT current_timestamp(),
`Gender`       set('Male', 'Female')  DEFAULT 'Male',
`PhoneNo`      varchar(200)           DEFAULT NULL,
`PlotName`     varchar(50)            DEFAULT NULL,
`FloorNo`      int(20)                DEFAULT NULL,
`DoorNo`       varchar(25)            DEFAULT NULL,
`Password`     varchar(200)           DEFAULT '*2470C0C06DEE42FD1618BB999005ADCA2EC9D1E19',
`ModifiedOn`   datetime               DEFAULT current_timestamp() ON UPDATE current_timestamp(),
`Email`        varchar(100)           DEFAULT NULL,
`Deleted`      varchar(10)            DEFAULT 'NO',
`DeletedOn`    datetime               DEFAULT NULL,
`UploadedOn`   datetime               DEFAULT NULL,
PRIMARY KEY (`RegNo`),
KEY `TenantName` (`TenantName`)
)
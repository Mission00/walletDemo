drop table if exists consume_detail;
create table consume_detail
(
    `id`          int auto_increment comment '主键ID'
        primary key,
    `wallet_id`   int      not null comment '钱包ID',
    `order_id`    int comment '订单ID',
    `create_time` datetime null comment '创建时间',
    `amount`      decimal  not null comment '消费金额',
    `type`        tinyint  not null comment '明细类型：0：充值 1：消费 3：退款',
    `remark`      varchar(125) comment '备注'
);

drop table if exists wallet;
create table wallet
(
    `id`          int auto_increment comment '主键ID'
        primary key,
    `user_id`     int               not null comment '用户ID',
    `name`        varchar(10)       not null comment '钱包名',
    `balance`     decimal default 0 not null comment '钱包余额',
    `create_time` datetime          not null comment '钱包创建时间',
    `modify_time` datetime          not null comment '钱包修改时间',
    `version`     int     default 0 not null comment '版本号'
);




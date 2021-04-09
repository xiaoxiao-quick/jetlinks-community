package org.jetlinks.community.device.entity;

import lombok.Getter;
import lombok.Setter;
import org.hswebframework.ezorm.rdb.mapping.annotation.ColumnType;
import org.hswebframework.ezorm.rdb.mapping.annotation.JsonCodec;
import org.hswebframework.web.api.crud.entity.GenericEntity;
import org.jetlinks.supports.protocol.management.ProtocolSupportDefinition;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.JDBCType;
import java.util.Map;

@Getter
@Setter
@Table(name = "dev_protocol")
public class ProtocolSupportEntity extends GenericEntity<String> {
    /**
     * 协议名称
     */
    @Column
    private String name;

    /**
     * 协议描述
     */
    @Column
    private String description;

    /**
     * 协议类型jar
     */
    @Column
    private String type;

    /**
     * 1 已发布
     * null  未发布
     */
    @Column
    private Byte state;

    /**
     * {"provider":"org.jetlinks.demo.protocol.DemoProtocolSupportProvider",
     * "location":"http://localhost:8848/upload/20210308/1368830255155486720.jar"}
     */
    @Column
    @ColumnType(jdbcType = JDBCType.CLOB)
    @JsonCodec
    private Map<String, Object> configuration;

    public ProtocolSupportDefinition toUnDeployDefinition() {
        ProtocolSupportDefinition definition = toDeployDefinition();
        definition.setState((byte) 0);
        return definition;
    }

    public ProtocolSupportDefinition toDeployDefinition() {
        ProtocolSupportDefinition definition = new ProtocolSupportDefinition();
        definition.setId(getId());
        definition.setConfiguration(configuration);
        definition.setName(name);
        definition.setProvider(type);
        definition.setState((byte) 1);

        return definition;
    }
}

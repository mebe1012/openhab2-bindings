package org.openhab.binding.philipstv.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openhab.binding.philipstv.internal.service.model.DataDto;
import org.openhab.binding.philipstv.internal.service.model.NodesDto;
import org.openhab.binding.philipstv.internal.service.model.TvSettingsCurrentDto;
import org.openhab.binding.philipstv.internal.service.model.TvSettingsUpdateDto;
import org.openhab.binding.philipstv.internal.service.model.ValueDto;
import org.openhab.binding.philipstv.internal.service.model.ValuesDto;

import java.util.Collections;

import static org.openhab.binding.philipstv.internal.ConnectionManager.OBJECT_MAPPER;

/**
 * Util class for common used methods from philips tv services
 *
 * @author Benjamin Meyer - initial contribution
 */
final class ServiceUtil {

    private ServiceUtil() {
    }

    static String createTvSettingsRetrievalJson(int nodeId) throws JsonProcessingException {
        TvSettingsCurrentDto tvSettingCurrent = new TvSettingsCurrentDto();
        NodesDto nodes = new NodesDto();
        nodes.setNodeid(nodeId);
        tvSettingCurrent.setNodes(Collections.singletonList(nodes));
        return OBJECT_MAPPER.writeValueAsString(tvSettingCurrent);
    }

    static String createTvSettingsUpdateJson(int nodeId, int valueToSet) throws JsonProcessingException {
        TvSettingsUpdateDto tvSetting = new TvSettingsUpdateDto();
        ValuesDto values = new ValuesDto();

        ValueDto value = new ValueDto();
        value.setNodeid(nodeId);

        DataDto data = new DataDto();
        data.setValue(valueToSet);

        value.setData(data);
        values.setValue(value);
        tvSetting.setValues(Collections.singletonList(values));
        return OBJECT_MAPPER.writeValueAsString(tvSetting);
    }
}

package org.dromara.daxpay.service.controller.config;

import cn.bootx.platform.core.rest.Res;
import cn.bootx.platform.core.rest.result.Result;
import org.dromara.daxpay.service.param.config.PlatformConfigParam;
import org.dromara.daxpay.service.result.config.PlatformConfigResult;
import org.dromara.daxpay.service.service.config.PlatformConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 平台配置
 * @author xxm
 * @since 2024/9/20
 */
@Tag(name = "平台配置")
@RestController
@RequestMapping("/platform/config")
@RequiredArgsConstructor
public class PlatformConfigController {
    private final PlatformConfigService platformConfigService;

    @Operation(summary = "获取配置")
    @GetMapping("/get")
    public Result<PlatformConfigResult> get() {
        return Res.ok(platformConfigService.getConfig().toResult());
    }

    @Operation(summary = "更新配置")
    @PostMapping("/update")
    public Result<Void> update(@RequestBody PlatformConfigParam param) {
        platformConfigService.update(param);
        return Res.ok();
    }
}

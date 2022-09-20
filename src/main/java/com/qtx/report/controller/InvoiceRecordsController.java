package com.qtx.report.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qtx.report.common.ResultObject;
import com.qtx.report.common.exception.DateException;
import com.qtx.report.config.MedioHttpRequestHandler;
import com.qtx.report.entity.InvoiceRecords;
import com.qtx.report.pojo.dto.InvoiceRecordsDto;
import com.qtx.report.pojo.vo.InvoiceRecordsVo;
import com.qtx.report.service.impl.InvoiceRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>
 * 发票记录表 前端控制器
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
@RestController
@RequestMapping("/report/invoiceRecords")
public class InvoiceRecordsController {

    @Autowired
    private InvoiceRecordsServiceImpl invoiceRecordsService;

    @PostMapping("/findPage")
    public ResultObject<IPage<InvoiceRecordsVo>> findPage(@RequestBody InvoiceRecordsDto dto) {
        return ResultObject.success(invoiceRecordsService.findPage(dto));
    }

    @PostMapping("/saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdateInfo(@RequestBody InvoiceRecords info) throws DateException {
        return ResultObject.success(invoiceRecordsService.saveOrUpdateNew(info));
    }

    @DeleteMapping("/remove")
    public ResultObject<Boolean> remove(@RequestParam Long id) {
        return ResultObject.success(invoiceRecordsService.removeById(id));
    }

    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws ClassNotFoundException {
        invoiceRecordsService.exportExcel(response);
    }

    @GetMapping("/download1")
    public void downloadExcel1(HttpServletResponse response) throws IOException {
        invoiceRecordsService.exportExcel1(response);
    }

    @Autowired
    private MedioHttpRequestHandler medioHttpRequestHandler;

    @GetMapping("/video")
    public void getPaly(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "E:\\";
        Path path = Paths.get(url + "123.mp4");
        if (Files.exists(path)) {
            String mimeType = Files.probeContentType(path);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(MedioHttpRequestHandler.ATTR_FILE, path);
            medioHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        /*
        定义文件的存储路径,如下，是在linux和mac上定义的文件路径
        /private/var/folders/8x/4zvnbqmj1w33cqmzrpygzbth0000gn/T/tomcat-docbase.5206733816001100271.8080/uploadFile
        */
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        File dir = new File(realPath);
        boolean mkdirs = false;
        if (!dir.isDirectory()) {
            //文件目录不存在，就创建一个
            mkdirs = dir.mkdirs();
        }
        if (!mkdirs) {
            // CommonMethod.failed(, DataEnums.USER_IS_FAIL);
        }
        try {
            String filename = file.getOriginalFilename();
            //服务端保存的文件对象
            assert filename != null;
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            file.transferTo(fileServer);
            //3，返回可供访问的网络路径
            return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                    "/uploadFile/" + filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}

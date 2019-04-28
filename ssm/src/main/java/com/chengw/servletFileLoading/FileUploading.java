package main.servletFileLoading;




import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;



public class FileUploading implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

        String tempPath = "D:/test/";

        File file = new File(tempPath);

        if(!file.exists())
            file.mkdirs();
        //设置临时文件夹
        fileItemFactory.setRepository(file);
        //设置缓冲区
        fileItemFactory.setSizeThreshold(1024*1024);





        //创建文件上传解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

        //解决上传文件名的中文乱码
        servletFileUpload.setHeaderEncoding("UTF-8");
        //3、判断提交上来的数据是否是上传表单的数据
        if(!ServletFileUpload.isMultipartContent(request)){
            //按照传统方式获取数据
            return;
        }

        //设置单个文件最大值
        servletFileUpload.setFileSizeMax(1024*1024*10);
        //设置总的最大值
        servletFileUpload.setSizeMax(1024*1024*1024);

        boolean isMulti = ServletFileUpload.isMultipartContent(request);


        if(isMulti){
            try {

                /*Map<String, List<FileItem>> fileItems = servletFileUpload.parseParameterMap(request);
                System.out.println(fileItems.size()); not work*/

                ServletInputStream servletInputStream = request.getInputStream();
                File uploadingFile = new File("D:/uploadingFiles/text.zip");
                if(!uploadingFile.exists())
                    uploadingFile.getParentFile().mkdir();
                    uploadingFile.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(uploadingFile);
                int temp;
                while((temp = servletInputStream.read() ) != -1){
                    fileOutputStream.write(temp);
                    System.out.println(temp);

                }


            }  catch (Exception e) {
                e.printStackTrace();
            }finally {

            }

        }



    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

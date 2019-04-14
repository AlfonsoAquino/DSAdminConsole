package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import jdk.nashorn.internal.runtime.regexp.joni.Option;

/**
 * Servlet implementation class AndroidFileServ
 */
@WebServlet("/AndroidFileServ")
@MultipartConfig
public class AndroidFileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Path up = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidFileServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                Part multiparts = request.getPart("bill");
	                InputStream filecontent = multiparts.getInputStream();
	                String sep = multiparts.getSubmittedFileName();
	                System.out.println(sep);
	                String [] splitted = sep.split("/");
	                //splitto perche come filename torna l'intero path dell'app in memoria
	                for(String s:splitted)
	                	System.out.println("spiltted: "+s);
	                
	                up = Paths.get("D:\\uploads\\"+splitted[6]);
	                Files.copy(filecontent,up,StandardCopyOption.REPLACE_EXISTING);
	                
	                response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("ok");
					out.flush();
	            
	               //File uploaded successfully
	               System.out.println("File Uploaded Successfully");
	            } catch (Exception ex) {
	            	System.out.println("File Upload Failed due to " + ex);
	            }          
	          
	        }else{
	        	System.out.println("Sorry this Servlet only handles file upload request");
	        }
		
	}

}

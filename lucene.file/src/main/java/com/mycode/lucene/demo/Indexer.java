package com.mycode.lucene.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


@SuppressWarnings({"javadoc","nls"})
public class Indexer {

	//写索引的实例
	private IndexWriter writer;

	/**   
	 * @throws IOException 
	 * @Title: Indexer       
	 */  
	public Indexer(String indexStr) throws IOException {
		
		//得到索引所在的路径
	    Directory dir = FSDirectory.open(Paths.get(indexStr));
	    
	    //实例化分析器
	    Analyzer analyzer = new StandardAnalyzer();
	    
	    //实例化IndexWriterConfig
	    IndexWriterConfig conf = new IndexWriterConfig(analyzer);
	    
	    //实例化IndexWriter
	    writer = new IndexWriter(dir, conf);
	    
	    writer.deleteAll();
	}
	
	/**
	 * 
	 * @Title: close    
	 * @throws IOException            
	 */
	public void close() throws IOException {
		writer.close();
	}
	
	/**
	 * 
	 * @Title: index   
	 * @param dataDir
	 * @return int            
	 * @throws IOException 
	 */
	public int index(String dataDir) throws IOException {
		File[] files = new File(dataDir).listFiles();
		for(File file : files) {
			indexFile(file);
		}
		
		return writer.numDocs();
	}

	/**
	 * @throws IOException    
	 * @Title: indexFile    
	 * @param file            
	 * @throws   
	 */  
	private void indexFile(File file) throws IOException {
		System.out.println("索引文件："+ file.getCanonicalPath());
		
		//索引要一行一行的找,在数据文件中为文档,所以要得到所有的行,也就是文档
		Document doc = getDocument(file);
	
		writer.addDocument(doc);

	}

	/**
	 * @throws IOException 
	 * @throws FileNotFoundException    
	 * @Title: getDocument   
	 * @return            
	 * @throws   
	 */  
	private Document getDocument(File file) throws IOException {
		Document doc = new Document();
		
		//add():把设置好的索引加到Document里，以便在确定被索引文档。
		doc.add(new TextField("contents",new FileReader(file)));
		
		//Field.Store.YES：把文件名存索引文件里，为NO就说明不需要加到索引文件里去
		doc.add(new TextField("FileName", file.getName(), Field.Store.YES));
		
		//把完整路径存在索引文件里
		doc.add(new TextField("fullPath", file.getCanonicalPath(),Field.Store.YES));
		
		return doc;
	}
	
	
	public static void main(String[] args) {
		String indexDir = ".\\file_index";
		String dataDir = ".\\file_data";
		
		//写索引
		
		Indexer indexer = null;
		int numIndex = 0;
		
		//索引开始时间
		long startTime = System.currentTimeMillis();
		
		try {
			indexer = new Indexer(indexDir);
			
			numIndex = indexer.index(dataDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				indexer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//索引结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("索引了"+ numIndex + " 个文件，花费了 "+(endTime - startTime)+" 毫秒");
		
	}
	
}

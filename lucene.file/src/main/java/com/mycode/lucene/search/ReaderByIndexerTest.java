package com.mycode.lucene.search;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

@SuppressWarnings({"javadoc","nls"})
public class ReaderByIndexerTest {

	public static void search(String indexDir, String q) throws IOException, ParseException {
		
		//读取索引文件路径
		Directory dir=FSDirectory.open(Paths.get(indexDir));
		
		//通过dir得到的路径下的所有的文件
		IndexReader reader=DirectoryReader.open(dir);
		
		//建立索引查询器
		IndexSearcher is = new IndexSearcher(reader);
		
		//实例化分析器
		Analyzer analyzer = new StandardAnalyzer();
		
		//建立查询解析器
		/**
		 * 第一个参数是要查询的字段
		 * 第二个参数是分析器analyzer
		 */
		QueryParser parser = new QueryParser("contents", analyzer);
		
		//根据传进来的p查找
		Query query = parser.parse(q);
		
		//计算索引开始时间
		long start=System.currentTimeMillis();
		
		//开始查询
		/**
		 * 第一个参数是通过传过来的参数来查找得到的query；
		 * 第二个参数是要出查询的行数
		 * */
		TopDocs hits=is.search(query, 10);
		
		//计算索引结束时间
		long end=System.currentTimeMillis();
		
		System.out.println("匹配 "+q+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
		
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("fullPath"));
			//System.out.println(doc.get("contents"));
		}
		
		reader.close();
	}
	
	
	
public static void main(String[] args) {
		
		String indexDir=".\\file_index";
		String q="ERROR";
		
		try {
		    search(indexDir,q);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		     e.printStackTrace();
		}
	}

}

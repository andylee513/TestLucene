 1、索引指定的文档路径的时候，在代码中为E:\\luceneDemo，必须为被索引文件的正确路径，否则会出现以下异常
   ```java
    org.apache.lucene.index.IndexNotFoundException: no segments* file found in SimpleFSDirectory@  D:\luceneDem lockFactory=org.apache.lucene.store.NativeFSLockFactory@eb724: files: []
    at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:726)
    at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:50)
    at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
    at readerByIndexer.ReaderByIndexerTest.search(ReaderByIndexerTest.java:32)
    at readerByIndexer.ReaderByIndexerTest.main(ReaderByIndexerTest.java:87)
    ```
     出现上述的问题有两个：第一是没有找到D:\\luceneDemo文件夹下的文件。有时还会出现空指针的异常。第二是没有关闭indexer
                   
  2、当写完索引后，想在测试一遍，先把被索引文件的文件夹下所产生的文件先删除，如若不删除，就是检索到重复的文档。    
  
  3、测试的参数和路径必须确定是完全正确的，有其是要查询的参数，否则会查到0个文档。

  4、这会需要检索的文档必须为全英文。

  5、注意导包是否正确
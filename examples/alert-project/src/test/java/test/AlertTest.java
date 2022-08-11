package test;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.Format;
import com.marklogic.client.io.StringHandle;
import org.junit.jupiter.api.Test;

public class AlertTest {

	@Test
	void test() {
		// URI of the document we'll insert
		final String uri = System.currentTimeMillis() + ".xml";

		DatabaseClient client = DatabaseClientFactory.newClient("localhost", 8017,
			new DatabaseClientFactory.DigestAuthContext("admin", "admin"));

		// Insert a document into the collection that we have the alerting pipeline attached to
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		metadata.withCollections("sample");
		client.newXMLDocumentManager().write(uri, metadata, new StringHandle(
			"<test>This has the word hello in it, so it should trigger our alert action</test>")
			.withFormat(Format.XML));

		// Check the TaskServer_ErrorLog.txt log file to verify that my-alert.xqy logged an entry
	}
}

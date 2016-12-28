package task3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents page that could be downloaded by specified URL.
 * Allows high-level access to page elements.
 */
public class Page {

    private static final Pattern imageLinkPattern = Pattern.compile("<img.*?src=\"(.*?)\".*?(/>|</img>)");

    private String content;
    private URL url;

    /**
     * Be careful, constructor downloads content, it could be slow.
     *
     * @param url
     * @throws IOException
     */
    public Page(URL url) throws IOException {
        this.url = new URL(url.getProtocol() + "://" + url.getHost());
        this.content = ConnectionUtils.toString(url);
    }

    /**
     * Extracts all links to images from the page like <img src={link}/>. Method does not cache content. Each time new list will be returned.
     *
     * @return list of URLs to images from that page.
     * @throws MalformedURLException
     */
    public Collection<URL> getImageLinks() throws MalformedURLException {
        return extractMatches(imageLinkPattern.matcher(content));
    }

    private Collection<URL> extractMatches(Matcher matcher) throws MalformedURLException {
        Collection<URL> urlCollection = new ArrayList<>();

        while (matcher.find()) {
            String urlName = url + "/" + matcher.group(1);
            urlCollection.add(new URL(urlName));
        }

        return urlCollection;
    }
}

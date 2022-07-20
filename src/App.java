import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //Abrir uma conexão HTTP com o IMDb

        //Extrato de conteudo da NASA
        String url ="https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        //Extrato de conteudo do IMDb
        //String url ="https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDb();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        //Exibir e manipular os dados
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradorDeFigurinhas();

        for (int i = 0; i < 3; i++){
     
        Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlimagem()).openStream();

            String nomeArquivo = "Imagens/" + conteudo.getTitulo() + ".png" ;

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
        }
        }

    }
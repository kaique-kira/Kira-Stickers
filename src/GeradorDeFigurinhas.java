import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    /**
     * @throws Exception
     */
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        //Leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        //criar nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem(em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        //Configurar a font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("Morreu enquanto lia", 10, novaAltura -250);

        //escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
        
    }
    
}

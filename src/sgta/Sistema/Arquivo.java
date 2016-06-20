package sgta.Sistema;

import java.io.File;

public class Arquivo {
	
	public final int idArquivo;
	public final int idAluno;
	protected File file;
	private final String fileName;
	
	public Arquivo(int idArquivos, int idAluno, File file, String fileName) {
		this.idArquivo = idArquivos;
		this.idAluno = idAluno;
		this.file = file;
		this.fileName = fileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getIdArquivo() {
		return idArquivo;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public String getFileName() {
		return fileName;
	}

}

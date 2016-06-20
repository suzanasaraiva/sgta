package sgta.Sistema;

import java.io.File;

public class Arquivo {
	
	public final int idArquivo;
	public final int idAluno;
	protected File file;
	
	public Arquivo(int idArquivos, int idAluno, File file) {
		this.idArquivo = idArquivos;
		this.idAluno = idAluno;
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getIdArquivos() {
		return idArquivo;
	}

	public int getIdAluno() {
		return idAluno;
	}
}

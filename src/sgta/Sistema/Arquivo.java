package sgta.Sistema;

import java.io.File;

public class Arquivo {
	
	public final int idArquivos;
	public final int idAluno;
	protected File file;
	
	public Arquivo(int idArquivos, int idAluno, File file) {
		this.idArquivos = idArquivos;
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
		return idArquivos;
	}

	public int getIdAluno() {
		return idAluno;
	}
}

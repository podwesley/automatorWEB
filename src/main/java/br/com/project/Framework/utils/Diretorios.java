package br.com.project.Framework.utils;

import br.com.project.Framework.exception.ProjetoExcecao;
import java.io.File;
import java.io.FilenameFilter;

public class Diretorios {

	private File[] matchingFiles = null;
	private String filePath = null;

	private String listar(File directory, final String startsWith, final String endsWith) {	
	
		if(directory.isDirectory()) {	
			String[] subDirectory = directory.list();
			if(subDirectory != null) {
				for(String dir : directory.list()){
					if (dir.startsWith(startsWith) && dir.endsWith(endsWith) && !directory.getPath().contains("bin")) {
						matchingFiles = directory.listFiles(new FilenameFilter() {
							public boolean accept(File dir, String name) {
								return name.startsWith(startsWith) && name.endsWith(endsWith);
							}
						});
						if(matchingFiles.length > 0){
							this.filePath = matchingFiles[0].getAbsolutePath().toString();
							Log.info(matchingFiles[0].toString());
						}
					}
					listar(new File(directory + File.separator  + dir), startsWith, endsWith);
					
				}
			}
		}		
		return this.filePath;			
	}

	public String getPathArquivo(String file)  {
			String[] fileWithExtension = file.split("\\.");
			String filePath = listar(new File("src" + File.separator), fileWithExtension[0], fileWithExtension[1]);
			if(filePath == null)
				throw new ProjetoExcecao("Arquivo não encontrado: " + file);
			return filePath;
	}

	public String getPathArquivo(String dir, String file)  {
			String[] fileWithExtension = file.split("\\.");
			String filePath =  listar(new File(dir + File.separator), fileWithExtension[0], fileWithExtension[1]);
			if(filePath == null)
				throw new ProjetoExcecao("Arquivo não encontrado: " + file + "dentro do diretorio: " + dir);
			return filePath;
			
	}

	
}
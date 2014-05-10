package br.com.redrails.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.util.Log;

public class Logger {
	File ARQUIVO = null;
	String TAG = "WA";

	public Logger(String filename) {
		ARQUIVO = new File("/sdcard/" + filename);
	}

	public static void clean_log() {
		new File("/sdcard/wa.log").delete();
	}

	// SALVAR ARQUIVOS
	public void salvar(String text) {
		SimpleDateFormat formatador = new SimpleDateFormat("[hh-mm-ss] ");
		Date today = new Date();
		String data = formatador.format(today);
		try {
			Log.d(TAG, "Escrevendo em " + ARQUIVO);
			FileWriter out = new FileWriter(ARQUIVO, true);
			out.append(data + text);
			out.close();

		} catch (IOException e) {
			Log.e(TAG, "Arquivo não pode criado ou escrito: " + e.getMessage());
		}
	}

	// CARREGAR ARQUIVOS
	public String carregar() {
		StringBuffer result = new StringBuffer();

		if (ARQUIVO.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(ARQUIVO));

				String linha;
				while ((linha = br.readLine()) != null) {
					result.append(linha + "\n");
				}
				//Log.d(TAG, "Arquivo carregado com sucesso: " + ARQUIVO);
				br.close();
			} catch (Exception e) {
				Log.e(TAG, "Erro ao tentar carregar o arquivo: " + ARQUIVO);
			}
		} else {
			Log.e(TAG, "Arquivo não pode ser carregado: " + ARQUIVO);
		}
		return result.toString();

	}

}

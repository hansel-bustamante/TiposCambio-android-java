package com.example.tiposcambio;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils; // Importación necesaria para manejar cadenas vacías o nulas
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText inputBolivianos;
	private TextView outputDolares, outputYenes, outputWones, outputChilenos,
			outputEuros, outputYuanes, outputReales, outputLibras,
			outputRupias, outputFrancos;
	private Button btnConvertir, btnLimpiar;

	// Definir las tasas de cambio
	private final double TASA_DOLAR = 0.1125; // 1 BOB = 0.14 USD
	private final double TASA_YEN = 20.5; // 1 BOB = 20.5 JPY
	private final double TASA_WON = 185.0; // 1 BOB = 185 KRW
	private final double TASA_CHILE = 100.0; // 1 BOB = 100 CLP
	private final double TASA_EURO = 0.12; // 1 BOB = 0.12 EUR
	private final double TASA_YUAN = 1.0; // 1 BOB = 1 CNY
	private final double TASA_REAL = 0.75; // 1 BOB = 0.75 BRL
	private final double TASA_LIBRA = 0.11; // 1 BOB = 0.11 GBP
	private final double TASA_RUPIA = 11.0; // 1 BOB = 11 INR
	private final double TASA_FRANCO = 0.12; // 1 BOB = 0.12 CHF

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Vincular componentes con el XML
		inputBolivianos = (EditText) findViewById(R.id.inputBolivianos);
		outputDolares = (TextView) findViewById(R.id.outputDolares);
		outputYenes = (TextView) findViewById(R.id.outputYenes);
		outputWones = (TextView) findViewById(R.id.outputWones);
		outputChilenos = (TextView) findViewById(R.id.outputChilenos);
		outputEuros = (TextView) findViewById(R.id.outputEuros);
		outputYuanes = (TextView) findViewById(R.id.outputYuanes);
		outputReales = (TextView) findViewById(R.id.outputReales);
		outputLibras = (TextView) findViewById(R.id.outputLibras);
		outputRupias = (TextView) findViewById(R.id.outputRupias);
		outputFrancos = (TextView) findViewById(R.id.outputFrancos);
		btnConvertir = (Button) findViewById(R.id.btnConvertir);
		btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

		// Evento de conversión
		btnConvertir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				convertirMonedas();
			}
		});

		// Evento de limpieza
		btnLimpiar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				limpiarCampos();
			}
		});
	}

	private void convertirMonedas() {
		String input = inputBolivianos.getText().toString();

		// Usar TextUtils.isEmpty() para evitar errores con cadenas vacías o
		// nulas
		if (TextUtils.isEmpty(input)) {
			Toast.makeText(this, "Ingrese un monto en bolivianos",
					Toast.LENGTH_SHORT).show();
			return;
		}

		try {
			double bolivianos = Double.parseDouble(input);

			// Calcular las conversiones
			double dolares = bolivianos * TASA_DOLAR;
			double yenes = bolivianos * TASA_YEN;
			double wones = bolivianos * TASA_WON;
			double chilenos = bolivianos * TASA_CHILE;
			double euros = bolivianos * TASA_EURO;
			double yuanes = bolivianos * TASA_YUAN;
			double reales = bolivianos * TASA_REAL;
			double libras = bolivianos * TASA_LIBRA;
			double rupias = bolivianos * TASA_RUPIA;
			double francos = bolivianos * TASA_FRANCO;

			// Mostrar los resultados
			outputDolares.setText(String.format("%.2f USD", dolares));
			outputYenes.setText(String.format("%.2f JPY", yenes));
			outputWones.setText(String.format("%.2f KRW", wones));
			outputChilenos.setText(String.format("%.2f CLP", chilenos));
			outputEuros.setText(String.format("%.2f EUR", euros));
			outputYuanes.setText(String.format("%.2f CNY", yuanes));
			outputReales.setText(String.format("%.2f BRL", reales));
			outputLibras.setText(String.format("%.2f GBP", libras));
			outputRupias.setText(String.format("%.2f INR", rupias));
			outputFrancos.setText(String.format("%.2f CHF", francos));
		} catch (NumberFormatException e) {
			Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT)
					.show();
		}
	}

	private void limpiarCampos() {
		inputBolivianos.setText("");
		outputDolares.setText("0.00 USD");
		outputYenes.setText("0.00 JPY");
		outputWones.setText("0.00 KRW");
		outputChilenos.setText("0.00 CLP");
		outputEuros.setText("0.00 EUR");
		outputYuanes.setText("0.00 CNY");
		outputReales.setText("0.00 BRL");
		outputLibras.setText("0.00 GBP");
		outputRupias.setText("0.00 INR");
		outputFrancos.setText("0.00 CHF");
	}
}

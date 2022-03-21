package br.com.estudos.contentapplicationclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdapter(private val mCursor: Cursor) : RecyclerView.Adapter<ClienteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder =
        ClienteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cliente_item, parent, false))


    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.itemTitulo.text = mCursor.getString(mCursor.getColumnIndex("titulo"))
        holder.itemDescricao.text = mCursor.getString(mCursor.getColumnIndex("descricao"))
    }

    override fun getItemCount(): Int = mCursor.count

}

class ClienteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemTitulo = itemView.findViewById(R.id.titulo_cliente_item) as TextView
        var itemDescricao = itemView.findViewById(R.id.descricao_cliente_item) as TextView
    }

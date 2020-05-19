import React, { Component} from 'react';
import './App.css';
import ReactTable from "react-table-v6";
import "react-table-v6/react-table.css";


class App extends Component {
  constructor(props){
    super(props);

    this.state = {
      post: []
    }
  }

  componentDidMount(){
    const url = "https://jsonplaceholder.typicode.com/posts";
    fetch(url,{
      method: "GET"
    }).then(reponse => reponse.json()).then(posts =>{
      this.setState({posts: posts})
    })
  }

  deleteRow(id){
    const index = this.state.posts.findIndex(post =>{
      return post.id === id
    })

    this.state.posts.splice(index, 1);
    this.setState({posts: this.state.posts});
  }


  render(){
    const columns = [
      {
        Header: "Product ID",
        accessor: "productID",
        style:{
          textAlign: "right"
        },
        width: 100,
        maxWidth: 100,
        minWidth: 100
      },
      {
        Header: "Product Name",
        accessor: "productName",
        style:{
          textAlign: "right"
        },
        width: 125,
        maxWidth: 125,
        minWidth: 125
      },
      {
        Header: "Product Description",
        accessor: "productDescription",
        sortable: false,
        filterable: false
      },
      {
        Header: "Product Count",
        accessor: "productCount",
        sortable: false,
        filterable: false,
        width: 150,
        maxWidth: 150,
        minWidth: 150
      },
      {
        Header: "Product Price",
        accessor: "productPrice",
        sortable: false,
        filterable: false,
        width: 150,
        maxWidth: 150,
        minWidth: 150
      },
      {
        Header: "Available",
        accessor: "productIsAvailable",
        sortable: false,
        filterable: false,
        width: 100,
        maxWidth: 100,
        minWidth: 100
      },
      {
        Header: "Actions",
        Cell: props =>{
          return(
            <button style={{backgroundColor: "green", color:"#fefefe"}}
            onClick={() =>{
              this.modifyRow(props.original.id);
            }}
          >Modify</button>
          )
        },
        sortable: false,
        filterable: false,
        width: 100,
        maxWidth: 100,
        minWidth: 100
      },
      {
        Header: "Actions",
        Cell: props =>{
          return(
            <button style={{backgroundColor: "red", color:"#fefefe"}}
              onClick={() =>{
                this.deleteRow(props.original.id);
              }}
            >Delete</button>
          )
        },

        sortable: false,
        filterable: false,
        width: 100,
        maxWidth: 100,
        minWidth: 100
      }
    ]
    return (
      <ReactTable
        columns={columns}
        data={this.state.posts}
        filterable
        defaultPageSize={10}
        noDataText={"Please Wait.."}
        
      >


      </ReactTable>
  );
  }
}

export default App;

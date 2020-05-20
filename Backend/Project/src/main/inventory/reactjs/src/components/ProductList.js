import React, {Component} from 'react';
import MyToast from './MyToast';
import {Card, Table, ButtonGroup, Button} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faList, faEdit, faTrash} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';

export default class ProductList extends Component{

    constructor(props){
        super(props);
        this.state = {
            list: []
        };
    }

    componentDidMount(){
        this.findAllProducts();
    }

    findAllProducts() {
        axios.get("http://localhost:8081/product/list")
            .then(response => response.data)
            .then((data) => {
                this.setState({list: data});
            });
    }

    deleteProduct = (productID) => {
        axios.delete("http://localhost:8081/assemblyline/delete/"+productID)
            .then(response => {
                if(response.data != null){
                    this.setState({"show":true});
                    setTimeout(() => this.setState({"show":false}), 3000);
                    this.setState({
                        products: this.state.products.filter(product => product.productID !== productID)
                    })
                } else {
                    this.setState({"show":false});
                }
            });
    }

    render(){
        return(

            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast children = {{show:this.state.show, message:"Product deleted successfully!", type:"danger"}}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Product List</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant ="dark">
                        <thead>
                            <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Product Description</th>
                            <th>Product Count</th>
                            <th>Product Price</th>
                            <th>Available</th>
                            <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.list.length === 0?
                                <tr align="center">
                                    <td colSpan="7">There are no available products.</td>
                                </tr> :
                                this.state.list.map((product) => (
                                <tr key={product.productID}>
                                    <td>{product.productID}</td>
                                    <td>{product.productName}</td>
                                    <td>{product.productDescription}</td>
                                    <td>{product.productCount}</td>
                                    <td>{product.productPrice+" Ft"}</td>
                                    <td>{product.productIsAvailable.toString()}</td>
                                    <td>
                                        <ButtonGroup>
                                            <Button size="sm" variant="outline-primary"><FontAwesomeIcon icon={faEdit} /></Button>{' '}
                                            <Button size="sm" variant="outline-danger" onClick={this.deleteProduct.bind(this, product.productID)}><FontAwesomeIcon icon={faTrash} /></Button>
                                        </ButtonGroup>

                                    </td>
                                </tr>
                                ))
                            }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
            </div>
        );
    }
}